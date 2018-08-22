package me.roots.leafa.command.commands.admin;

import me.roots.leafa.command.managers.LeafaCommand;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandDeveloper extends LeafaCommand {

    public CommandDeveloper() {
        super(
                "dev",
                "BOT_OWNER",
                "Um comando para o desenvolvedor da Leafa."
        );
    }

    @Override
    public void run(MessageReceivedEvent event, String[] args) {
        if (!event.getAuthor().getDiscriminator().equalsIgnoreCase("3156")) {
            event.getChannel().sendMessage(":x: Você não tem a permissão: **BOT_OWNER** para executar este comando :x:").queue();
            return;
        }
        switch (args[0]) {
            case "reload":
                // TODO code.
                event.getAuthor().openPrivateChannel().complete().sendMessage(":white_check_mark: Reiniciando o bot... :white_check_mark:").queue();
                break;
            case "stop":
                // TODO code.
                event.getAuthor().openPrivateChannel().complete().sendMessage(":white_check_mark: Parando o bot... :white_check_mark:").queue();
                break;
            default:
                String arguments = "**reload, stop**";
                event.getAuthor().openPrivateChannel().complete().sendMessage(":x: Use os seguintes argumentos para esse comando: " + arguments).queue();
                break;
        }
    }
}
