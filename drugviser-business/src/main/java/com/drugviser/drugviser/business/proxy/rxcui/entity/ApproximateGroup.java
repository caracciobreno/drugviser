package com.drugviser.drugviser.business.proxy.rxcui.entity;

import java.util.List;

public class ApproximateGroup {

    private String inputTerm;
    private String maxEntries;
    private Object comment;
    private List<Candidate> candidate = null;

    public String getInputTerm() {
        return inputTerm;
    }

    public void setInputTerm(String inputTerm) {
        this.inputTerm = inputTerm;
    }

    public String getMaxEntries() {
        return maxEntries;
    }

    public void setMaxEntries(String maxEntries) {
        this.maxEntries = maxEntries;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public List<Candidate> getCandidate() {
        return candidate;
    }

    public void setCandidate(List<Candidate> candidate) {
        this.candidate = candidate;
    }
}
