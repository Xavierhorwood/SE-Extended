package me.rhunk.snapenhance.core.features.impl.experiments

import me.rhunk.snapenhance.core.features.Feature
import me.rhunk.snapenhance.core.util.hook.HookStage
import me.rhunk.snapenhance.core.util.hook.hookConstructor
import me.rhunk.snapenhance.mapper.impl.ScoreMapper

class ScoreChange : Feature("ScoreChange") {
    override fun init() {
        if (!context.config.experimental.ScoreChange.get()) return

        onNextActivityCreate(defer = true) {
            context.mappings.useMapper(ScoreMapper::class) {
                classReference.get()?.hookConstructor(HookStage.BEFORE) { param ->
                    //val startTimeMillis = param.arg<Long>(1)
                    //reset timestamp if it's more than 24 hours
                    //if (System.currentTimeMillis() - startTimeMillis > 86400000) {
                    //    param.setArg(1, 0)
                    //    param.setArg(2, 0)
                    //}

                    param.setArg(3, 5000)
                }
            }
        }
    }
}