package me.roots.leafa.command.commands.admin;

import me.roots.leafa.command.pivaman.LeafaCommand;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandDeveloper extends LeafaCommand {

    public CommandDeveloper() {
        super(
                "dev",
                "cmd.admin",
                "Um comando auxiliar para o desenvolvimento da Leafa :D"
        );
    }

    @Override
    public void run(MessageReceivedEvent e, String[] args) {
        /*TODO aqui você faz o comando
        System.out.println("top");*/
    }
}
