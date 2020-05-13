package com.SCAN;

public class Arguments {

    private String directory;
    private String reportFile;
    private String extend;

    public Arguments(String directory, String reportFile, String extend) {
        this.directory = directory;
        this.reportFile = reportFile;
        this.extend = extend;
    }

    public String getDirectory() {
        return directory;
    }

    public String getReportFile() {
        return reportFile;
    }

    public String getExtend() {
        return extend;
    }

}
