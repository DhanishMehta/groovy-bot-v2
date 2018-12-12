package co.groovybot.bot.listeners;

import co.groovybot.bot.GroovyBot;
import co.groovybot.bot.core.entity.EntityProvider;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.SubscribeEvent;

public class SelfMentionListener {

    @SubscribeEvent
    @SuppressWarnings("unused")
    private void onMention(GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equals(event.getGuild().getSelfMember().getAsMention())) {
            event.getChannel().sendMessage(String.format("\uD83D\uDD96 **Wazzup mate**, my name is **Groovy** and my **prefix** on this guild is **`%s`**", EntityProvider.getGuild(event.getGuild().getIdLong()) == null ? EntityProvider.getGuild(event.getGuild().getIdLong()).getPrefix() : GroovyBot.getInstance().getConfig().getJSONObject("settings").getString("prefix"))).queue();
        }
    }
}