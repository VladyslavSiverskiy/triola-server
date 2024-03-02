package com.vsiverskyi.dataimport.exception.scanning;

public class ScanningWasNotCompletedException extends RuntimeException {
    public ScanningWasNotCompletedException(String message) {
        super(message);
    }
}
