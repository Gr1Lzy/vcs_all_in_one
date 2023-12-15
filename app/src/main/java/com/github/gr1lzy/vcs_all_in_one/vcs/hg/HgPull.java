package com.github.gr1lzy.vcs_all_in_one.vcs.hg;

import com.github.gr1lzy.vcs_all_in_one.shell.CommandArg;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandBuilder;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class HgPull implements Callable<ArrayList<String>> {
    @Override
    public ArrayList<String> call() throws Exception {
        CommandBuilder builder = Hg.hgBuilder().addArguments(
                new CommandArg("pull"),
                new CommandArg("-u"));
        return new CommandLine(builder).call();
    }
}
