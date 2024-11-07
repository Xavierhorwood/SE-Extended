package me.rhunk.snapenhance.core.features.impl.ui

import me.rhunk.snapenhance.core.features.Feature
import me.rhunk.snapenhance.common.data.RuleState
import me.rhunk.snapenhance.core.util.hook.HookStage
import me.rhunk.snapenhance.core.util.hook.Hooker
import me.rhunk.snapenhance.core.util.hook.hook
import me.rhunk.snapenhance.core.util.hook.hookConstructor
import me.rhunk.snapenhance.core.util.ktx.getObjectField
import me.rhunk.snapenhance.core.util.ktx.setObjectField
import me.rhunk.snapenhance.core.wrapper.impl.SnapUUID
import android.widget.Toast

class Wallpaperupdate : Feature("Block Wallpaper Update") {
    override fun init() {
        if (!context.config.userInterface.blockWallpaperUpdate.get()) return

        context.classCache.conversationManager.hook("updateChatWallpaper", HookStage.BEFORE) { param ->
            Toast.makeText(context.androidContext, "Wallpaper update blocked", Toast.LENGTH_SHORT).show()
            param.setResult(null)
        }
    }
}