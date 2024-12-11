package me.rhunk.snapenhance.mapper.impl

import me.rhunk.snapenhance.mapper.AbstractClassMapper
import me.rhunk.snapenhance.mapper.ext.findConstString
import me.rhunk.snapenhance.mapper.ext.getClassName
import me.rhunk.snapenhance.mapper.ext.searchNextFieldReference

class ScoreMapper : AbstractClassMapper("Score"){
    val classReference = classReference("class")

    init {
        mapper {
            for (clazz in classes) {
                val firstConstructor = clazz.directMethods.firstOrNull { it.name == "<init>" } ?: continue
                if (firstConstructor.parameters.size != 5) continue
                //if (firstConstructor.parameterTypes[1] != "str" || firstConstructor.parameterTypes[2] != "str2") continue

                if (clazz.methods.firstOrNull { it.name == "toString" }?.implementation?.findConstString("Result\\(userId=", contains = true) != true) continue

                classReference.set(clazz.getClassName())
                return@mapper
            }
        }
    }
}