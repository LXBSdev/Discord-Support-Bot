package main.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.*;
import org.jetbrains.annotations.NotNull;

public class MemberJoinListener extends ListenerAdapter {

    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {

        User user = event.getUser();
        Member member = event.getMember();
        String profile = event.getUser().getAvatarUrl();

        EmbedBuilder emb = new EmbedBuilder();

        emb.setTitle("Welcome to LXBS!");
        emb.setColor(member.getColor());
        emb.setDescription("Welcome **" + user.getAsMention() + "** to lxbs.online!");
        emb.setThumbnail(profile);
        emb.addField("Have Fun", "More infos at [lxbs.online](http://lxbs.online)", false);

        event.getGuild().getTextChannelById("965307484296347658").sendMessageEmbeds(emb.build()).queue();
        if (event.getUser().isBot()) {
            event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("983417133742567475"))
                    .queue();
            event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("1122511805982457866"))
                    .queue();
        }
    }
}
