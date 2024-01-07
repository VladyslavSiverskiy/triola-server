package com.vsiverskyi.exception.scanning;

public class ScanningWasNotCompletedException extends RuntimeException {
    public ScanningWasNotCompletedException(String message) {
        super(message);
    }
}
