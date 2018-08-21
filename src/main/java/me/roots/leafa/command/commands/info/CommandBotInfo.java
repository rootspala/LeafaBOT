package me.roots.leafa.command.commands.info;

import me.roots.leafa.command.pivaman.LeafaCommand;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class CommandBotInfo extends LeafaCommand {

    public CommandBotInfo() {
        super(
                "help",
                null,
                "Comando para exibir ajuda"
        );
    }

    @Override
    public void run(MessageReceivedEvent event, String args[]) {
        User user = event.getAuthor();

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(Color.GREEN);
        embedBuilder.setAuthor(user.getName(), user.getAvatarUrl(), user.getAvatarUrl());

        embedBuilder.setDescription(":question: Informações da BOT:");

        embedBuilder.addField(":woman: Nome de Usuário:", event.getJDA().getSelfUser().getName(), false);
        embedBuilder.addField(":gear: Versão do JDA:", "3.7.1_397", false);
        embedBuilder.addField(":exclamation: Prefix Universal:", ":regional_indicator_l::exclamation:", false);
        embedBuilder.addField("Nacionalidade:", ":flag_jp: Japão - Japan", false);
        embedBuilder.addField(":interrobang: ping:", String.valueOf(event.getJDA().getPing()), false);

        embedBuilder.setFooter("Em breve mais informações...", user.getAvatarUrl());

        event.getChannel().sendMessage(embedBuilder.build()).queue();
    }

}
