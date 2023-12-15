package com.github.gr1lzy.vcs_all_in_one.vcs.hg;

import com.github.gr1lzy.vcs_all_in_one.shell.CommandArg;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandBuilder;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

class HgPush implements Callable<ArrayList<String>> {
    @Override
    public ArrayList<String> call() throws Exception {
        CommandBuilder builder = Hg.hgBuilder().addArguments(new CommandArg("push"));
        return new CommandLine(builder).call();
    }
}
