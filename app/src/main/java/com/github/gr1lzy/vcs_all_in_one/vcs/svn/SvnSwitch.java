package com.github.gr1lzy.vcs_all_in_one.vcs.svn;

import com.github.gr1lzy.vcs_all_in_one.shell.CommandArg;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandBuilder;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class SvnSwitch implements Callable<ArrayList<String>> {
    private final String branch;

    public SvnSwitch(String branch) {
        this.branch = branch;
    }

    @Override
    public ArrayList<String> call() throws Exception {
        CommandBuilder builder = Svn.svnBuilder().addArguments(
                new CommandArg("switch"),
                new CommandArg(branch));
        return new CommandLine(builder).call();
    }
}
