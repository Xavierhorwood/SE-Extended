package me.rhunk.snapenhance.core.features.impl.ui

import me.rhunk.snapenhance.common.data.MessagingRuleType
import me.rhunk.snapenhance.common.data.RuleState
import me.rhunk.snapenhance.core.features.MessagingRuleFeature
import me.rhunk.snapenhance.core.util.hook.HookStage
import me.rhunk.snapenhance.core.util.hook.Hooker
import me.rhunk.snapenhance.core.util.hook.hook
import me.rhunk.snapenhance.core.util.hook.hookConstructor
import me.rhunk.snapenhance.core.util.ktx.getObjectField
import me.rhunk.snapenhance.core.util.ktx.setObjectField
import me.rhunk.snapenhance.core.wrapper.impl.SnapUUID

class Wallpaperupdate : MessagingRuleFeature("Wallpaperupdate", MessagingRuleType.WALLPAPERUPDATE) {
    override fun init() {
        //if (!context.config.messaging.unlimitedConversationPinning.get()) return

        context.classCache.updatewallpaper.hook("updateChatWallpaper", HookStage.BEFORE) { param ->
            return@hook
        }
    }

    override fun getRuleState() = RuleState.WHITELIST
}