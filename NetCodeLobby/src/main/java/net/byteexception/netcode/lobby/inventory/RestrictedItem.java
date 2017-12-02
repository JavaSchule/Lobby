package net.byteexception.netcode.lobby.inventory;

import net.byteexception.netcode.lobby.user.User;

public interface RestrictedItem {

    boolean hasPermission(User user);

}
