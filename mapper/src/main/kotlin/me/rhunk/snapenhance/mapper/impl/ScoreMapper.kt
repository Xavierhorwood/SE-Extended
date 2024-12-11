package me.rhunk.snapenhance.mapper.impl

import me.rhunk.snapenhance.mapper.AbstractClassMapper
import me.rhunk.snapenhance.mapper.ext.findConstString
import me.rhunk.snapenhance.mapper.ext.getClassName
import me.rhunk.snapenhance.mapper.ext.searchNextFieldReference

class ScoreMapper : AbstractClassMapper("Score"){
    val classReference = classReference("class")
    val scoreField = string("scoreField")

    init {
        mapper {
            for (clazz in classes) {
                if (clazz.directMethods.filter { it.name == "<init>" }.none {
                    //public C7952Pii(C30909nl8 c30909nl8, String str, String str2, long j, Date date, String str3) {
                    it.parameterTypes.size > 5
                }) continue

                val toStringMethod = clazz.virtualMethods.firstOrNull { it.name == "toString" }?.implementation ?: continue
                if (!toStringMethod.let {
                    it.findConstString("Result\\(userId", contains = true) && it.findConstString("score", contains = true)
                }) continue

                classReference.set(clazz.getClassName())

                /*
                public final String toString() {
        StringBuilder sb = new StringBuilder("Result(userId=");
        sb.append(this.a);
        sb.append(", displayUserName=");
        sb.append(this.b);
        sb.append(", displayName=");
        sb.append(this.c);
        sb.append(", score=");
        sb.append(this.d);
        sb.append(", birthDate=");
        sb.append(this.e);
        sb.append(", countryCode=");
        return AbstractC35771rbf.t(sb, this.f, ')');
    }*/


                toStringMethod.apply {
                    //searchNextFieldReference("tier", contains = true)?.let { tierField.set(it.name) }
                    //searchNextFieldReference("status", contains = true)?.let { statusField.set(it.name) }
                    //searchNextFieldReference("original", contains = true)?.let { originalSubscriptionTimeMillisField.set(it.name) }
                    //searchNextFieldReference("expirationTimeMillis", contains = true)?.let { expirationTimeMillisField.set(it.name) }

                    searchNextFieldReference("score", contains = true)?.let { scoreField.set(it.name) }
                }

                return@mapper
            }
        }
    }
}