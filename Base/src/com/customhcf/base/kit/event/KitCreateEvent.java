/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.event.Cancellable
 *  org.bukkit.event.Event
 *  org.bukkit.event.HandlerList
 */
package com.customhcf.base.kit.event;

import com.customhcf.base.kit.Kit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class KitCreateEvent
extends Event
implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Kit kit;
    private boolean cancelled = false;

    public KitCreateEvent(Kit kit) {
        this.kit = kit;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Kit getKit() {
        return this.kit;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
