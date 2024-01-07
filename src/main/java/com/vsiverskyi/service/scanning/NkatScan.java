package com.vsiverskyi.service.scanning;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.vsiverskyi.exception.scanning.ScanningWasNotCompletedException;
import com.vsiverskyi.model.Accountant;
import com.vsiverskyi.model.Category;
import com.vsiverskyi.model.Unit;
import com.vsiverskyi.model.balance.Balance;
import com.vsiverskyi.model.groups.CategoryGroup;
import com.vsiverskyi.model.groups.PlatVidomGroup;
import com.vsiverskyi.model.groups.UnitGroup;
import com.vsiverskyi.repository.CategoryRepo;
import com.vsiverskyi.repository.balance.BalanceRepo;
import com.vsiverskyi.repository.groups.BalanceGroupRepo;
import com.vsiverskyi.repository.groups.CategoryGroupRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.charset.Charset;

@Slf4j
@Service
@RequiredArgsConstructor
public class NkatScan {


    @Value("${paths.dbf.root}")
    private String dbfRoot;
    private DBFReader nkatReader;
    private DBFReader nkatGruReader;
    private final CategoryGroupRepo categoryGroupRepo;
    private final CategoryRepo categoryRepo;


    @PostConstruct
    private void postConstruct() throws FileNotFoundException {
        nkatReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "nkat.DBF"),  Charset.forName("windows-1251"));
        nkatGruReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "nkatgru.DBF"),  Charset.forName("windows-1251"));
    }

    public void scanCategories() {
        scanNkatGru();
        scanNkat();
    }

    private void scanNkat() {
        try {
            DBFRow row;
            while ((row = nkatReader.nextRow()) != null) {

                String kkatGru = row.getString("KKATGRU");
                CategoryGroup categoryGroup = null;
                if (!kkatGru.isEmpty()) {
                    categoryGroup = categoryGroupRepo.findById(kkatGru)
                            .orElseThrow(() -> new ScanningWasNotCompletedException("Category group doesn't exist."));
                }
                Category category = Category.builder()
                        .code(row.getString("KKAT"))
                        .title(row.getString("NKAT"))
                        .categoryGroup(categoryGroup)
                        .oklSum(BigDecimal.valueOf(Double.valueOf(row.getString("SOKL"))))
                        .kkatokl(row.getString("KKATOKL"))
                        .nkatmax(row.getString("NKATMAX"))
                        .build();

                categoryRepo.save(category);
            }
            log.info("Nkat was successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(nkatReader);
        }
    }

    private void scanNkatGru() {
        try {
            DBFRow row;
            while ((row = nkatGruReader.nextRow()) != null) {
                CategoryGroup unitGroup = CategoryGroup.builder()
                        .code(row.getString("KKATGRU"))
                        .title(row.getString("NKATGRU"))
                        .build();
                categoryGroupRepo.save(unitGroup);
            }
            log.info("Category groups were successfully imported");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ScanningWasNotCompletedException(e.getMessage());
        } finally {
            DBFUtils.close(nkatGruReader);
        }
    }


}
