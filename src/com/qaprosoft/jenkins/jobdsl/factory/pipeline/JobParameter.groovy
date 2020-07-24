package com.qaprosoft.jenkins.jobdsl.factory.pipeline

class JobParameter {
    def paramType = ""
    def paramDescription = ""
    def paramValue = null

    public JobParameter(paramType, paramDescription, paramValue) {
        this.paramType = paramType
        this.paramDescription = paramDescription
        this.paramValue = paramValue
    }

    public getParamType() {
        return this.paramType
    }

    public getParamDescription() {
        return this.paramValue
    }

    public getParamValue() {
        return this.paramValue
    }
}
