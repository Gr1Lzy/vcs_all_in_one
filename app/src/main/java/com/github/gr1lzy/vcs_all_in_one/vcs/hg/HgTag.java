package com.github.gr1lzy.vcs_all_in_one.vcs.hg;

import com.github.gr1lzy.vcs_all_in_one.shell.CommandArg;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandBuilder;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class HgTag implements Callable<ArrayList<String>> {
    private final String tagName;

    public HgTag(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public ArrayList<String> call() throws Exception {
        CommandBuilder builder = Hg.hgBuilder().addArguments(
                new CommandArg("tag"),
                new CommandArg(tagName));
        return new CommandLine(builder).call();
    }
}
