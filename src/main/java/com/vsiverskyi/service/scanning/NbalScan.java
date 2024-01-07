package com.vsiverskyi.service.scanning;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.vsiverskyi.exception.scanning.ScanningWasNotCompletedException;
import com.vsiverskyi.model.balance.Balance;
import com.vsiverskyi.model.balance.Bank;
import com.vsiverskyi.model.balance.Company;
import com.vsiverskyi.model.balance.Manager;
import com.vsiverskyi.model.groups.BalanceGroup;
import com.vsiverskyi.repository.balance.BalanceRepo;
import com.vsiverskyi.repository.balance.BankRepo;
import com.vsiverskyi.repository.balance.CompanyRepo;
import com.vsiverskyi.repository.balance.ManagerRepo;
import com.vsiverskyi.repository.groups.BalanceGroupRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;

@Slf4j
@Service
@RequiredArgsConstructor
public class NbalScan {

	@Value("${paths.dbf.root}")
	private String dbfRoot;
    private DBFReader nbalReader;
    private DBFReader nbalGruReader;
	private final BalanceGroupRepo nbalGruRepo;
	private final BalanceRepo balanceRepo;
	private final BankRepo bankRepo;
	private final CompanyRepo companyRepo;
	private final ManagerRepo managerRepo;

    @PostConstruct
    private void postConstruct() throws FileNotFoundException {
        nbalReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "Nbal.DBF"),  Charset.forName("windows-1251"));
        nbalGruReader = new DBFReader(new FileInputStream(dbfRoot + File.separator + "Nbalgru.DBF"),  Charset.forName("windows-1251"));
	}

    public void scanBalances() throws ScanningWasNotCompletedException{
		scanNbalGru();
		scanNbal();
    }

	private void scanNbal() {
		try {
			DBFRow row;
			while ((row = nbalReader.nextRow()) != null) {
				Bank bank = Bank.builder()
						.title(row.getString("NBAN"))
						.krozrah(row.getString("KROZRAH"))
						.mfo(row.getString("MFO"))
						.build();
				bank = bankRepo.save(bank);

				Manager manager = Manager.builder()
						.nameAndSurname(row.getString("NKER"))
						.idCode(row.getString("KIDEKER"))
						.phone(row.getString("KTELKER"))
						.position(row.getString("NPOSKER"))
						.build();
				manager = managerRepo.save(manager);

				Company company = Company.builder()
						.fullTitle(row.getString("NFIR"))
						.shortTitle(row.getString("NFIRMIN"))
						.edrpou(row.getString("KIDEFIR"))
						.pfEdrpou(row.getString("KIDEFIRPEN"))
						.address(row.getString("NADRFIR"))
						.phone(row.getString("KTELFIR"))
						.kpkKfk(row.getString("KPK"))
						.build();
				company = companyRepo.save(company);

				String kbalGru = row.getString("KBALGRU");
				BalanceGroup balanceGroup = null;
				if (!kbalGru.isEmpty()) {
					 balanceGroup = nbalGruRepo.findById(kbalGru)
							.orElseThrow(() -> new ScanningWasNotCompletedException("Balance group doesn't exist."));
				}
				Balance balance = Balance.builder()
						.code(row.getString("KBAL"))
						.balanceGroup(balanceGroup)
						.title(row.getString("NBAL"))
						.company(company)
						.bank(bank)
						.manager(manager)
						.accountantNameAndSurname(row.getString("NBUH"))
						.accountantPhone(row.getString("KTELBUH"))
						.accountantIdCode(row.getString("KIDEBUH"))
						.accountantPosition(row.getString("NPOSBUH"))
						.regionCode(row.getString("KOBL"))
						.codeDpi(row.getString("KDPA"))
						.edrpou(row.getString("KIDEDPA"))
						.dpiName(row.getString("NDPA"))
						.registerNumber(row.getString("KREESOC"))
						.registerNumber2(row.getString("KREESOC2"))
						.fondName(row.getString("NSOC"))
						.voManagerName(row.getString("NKERSOC"))
						.bankRR(row.getString("KROZRAHSOC"))
						.mfoSoc(row.getString("MFOSOC"))
						.voSoc(Boolean.valueOf(row.getString("LVOSOC")))
						.orderCount(Long.valueOf(row.getString("KRAHKT")))
						.doNotTransferToBank(Boolean.valueOf(row.getString("PNOTBAN")))
						.nmo5(row.getString("NMO5"))
						.build();
				balanceRepo.save(balance);
			}
			log.info("Nbal was successfully imported");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ScanningWasNotCompletedException(e.getMessage());
		} finally {
			DBFUtils.close(nbalReader);
		}
	}

    private void scanNbalGru() throws ScanningWasNotCompletedException{
		try {
			DBFRow row;
			while ((row = nbalGruReader.nextRow()) != null) {
				BalanceGroup balanceGroup = BalanceGroup.builder()
						.code(row.getString("KBALGRU"))
						.title(row.getString("NBALGRU"))
						.build();
				nbalGruRepo.save(balanceGroup);
			}
			log.info("Nbal group was successfully imported");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ScanningWasNotCompletedException(e.getMessage());
		} finally {
			DBFUtils.close(nbalGruReader);
		}
    }
}
