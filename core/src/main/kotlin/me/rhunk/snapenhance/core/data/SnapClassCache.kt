package me.rhunk.snapenhance.core.data

class SnapClassCache (
    private val classLoader: ClassLoader
) {
    val snapUUID by lazy { findClass("com.snapchat.client.messaging.UUID") }
    val snapManager by lazy { findClass("com.snapchat.client.messaging.SnapManager\$CppProxy") }
    val conversationManager by lazy { findClass("com.snapchat.client.messaging.ConversationManager\$CppProxy") }
    val presenceSession by lazy { findClass("com.snapchat.talkcorev3.PresenceSession\$CppProxy") }
    val message by lazy { findClass("com.snapchat.client.messaging.Message") }
    val messageUpdateEnum by lazy { findClass("com.snapchat.client.messaging.MessageUpdate") }
    val serverMessageIdentifier by lazy { findClass("com.snapchat.client.messaging.ServerMessageIdentifier") }
    val unifiedGrpcService by lazy { findClass("com.snapchat.client.grpc.UnifiedGrpcService\$CppProxy") }
    val networkApi by lazy { findClass("com.snapchat.client.network_api.NetworkApi\$CppProxy") }
    val messageDestinations by lazy { findClass("com.snapchat.client.messaging.MessageDestinations") }
    val localMessageContent by lazy { findClass("com.snapchat.client.messaging.LocalMessageContent") }
    val feedEntry by lazy { findClass("com.snapchat.client.messaging.FeedEntry") }
    val conversation by lazy { findClass("com.snapchat.client.messaging.Conversation") }
    val feedManager by lazy { findClass("com.snapchat.client.messaging.FeedManager\$CppProxy") }
    val nativeBridge by lazy { findClass("com.snapchat.client.composer.NativeBridge") }
    val composerView by lazy { findClass("com.snap.composer.views.ComposerView") }
    val composerAction by lazy { findClass("com.snap.composer.actions.ComposerAction") }
    val composerFunctionActionAdapter by lazy { findClass("com.snap.composer.callable.ComposerFunctionActionAdapter") }

    private fun findClass(className: String): Class<*> {
        return try {
            classLoader.loadClass(className)
        } catch (e: ClassNotFoundException) {
            throw RuntimeException("Failed to find class $className", e)
        }
    }
}