package me.roots.leafa.command.commands.admin;

import me.roots.leafa.command.managers.LeafaCommand;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandDeveloper extends LeafaCommand {

    public CommandDeveloper(String name, String permission, String description) {
        super("dev", "BOT_OWNER", "Um comando para o desenvolvedor do BOT.");
    }

    @Override
    public void run(MessageReceivedEvent event, String[] args) {
        // SECRET
    }
}
