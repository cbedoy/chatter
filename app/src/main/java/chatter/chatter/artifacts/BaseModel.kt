package chatter.chatter.artifacts

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
interface BaseModel{
    fun getType() : Int

    fun getId() : String

    enum class TYPE private constructor(val value: Int) {
        CHANNEL(1),
        BUDDY(2),
        SETTINGS(3),
        HEADER(4),
        ACTION(5),
        OPTION(6),
        DIVIDER(7),
        MESSAGE(8),
        DIVIDER_TITLE(9),
    }
}