package com.github.gr1lzy.vcs_all_in_one.vcs;

import java.util.ArrayList;

public interface VCSLogParser {
    ArrayList<VCSCommit> parse(ArrayList<String> rawLog) throws Exception;
}