package me.teenaapje.referral.placeholders;

import me.teenaapje.referral.ReferralCore;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.jetbrains.annotations.NotNull;

public class PlaceHolders extends PlaceholderExpansion{
	/**
     * Because this is an internal class,
     * you must override this method to let PlaceholderAPI know to not unregister your expansion class when
     * PlaceholderAPI is reloaded
     *
     * @return true to persist through reloads
     */
    @Override
    public boolean persist(){
        return true;
    }

    /**
     * Because this is a internal class, this check is not needed
     * and we can simply return {@code true}
     *
     * @return Always true since it's an internal class.
     */
    @Override
    public boolean canRegister(){
        return true;
    }

    /**
     * The name of the person who created this expansion should go here.
     * <br>For convienience do we return the author from the plugin.yml
     * 
     * @return The name of the author as a String.
     */
    @Override
    public @NotNull String getAuthor(){
        return ReferralCore.core.getDescription().getAuthors().toString();
    }

    /**
     * The placeholder identifier should go here.
     * <br>This is what tells PlaceholderAPI to call our onRequest 
     * method to obtain a value if a placeholder starts with our 
     * identifier.
     * <br>This must be unique and can not contain % or _
     *
     * @return The identifier in {@code %<identifier>_<value>%} as String.
     */
    @Override
    public @NotNull String getIdentifier(){
        return ReferralCore.core.getDescription().getName().toLowerCase();
    }

    /**
     * This is the version of the expansion.
     * <br>You don't have to use numbers, since it is set as a String.
     * <p>
     * For convienience do we return the version from the plugin.yml
     *
     * @return The version as a String.
     */
    @Override
    public @NotNull String getVersion(){
        return ReferralCore.core.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player p, @NotNull String params) {
        if(p == null) {
            return "";
        }

        if(params.equals("total")) {
            return Integer.toString(ReferralCore.core.db.GetReferrals(p.getUniqueId().toString(), p.getName()));
        }
        
        if(params.equals("refed")) {
            return Boolean.toString(ReferralCore.core.db.PlayerReferrald(p.getUniqueId().toString(), p.getName()));
        }

        return null;
    }
    
    @Override
    public String onRequest(OfflinePlayer p, @NotNull String params) {
    	if(p == null) {
            return "";
        }

        if(params.equals("total")) {
            return Integer.toString(ReferralCore.core.db.GetReferrals(p.getUniqueId().toString(), p.getName()));
        }
        
        if(params.equals("refed")) {
            return Boolean.toString(ReferralCore.core.db.PlayerReferrald(p.getUniqueId().toString(), p.getName()));
        }

        return null;
    }
}
