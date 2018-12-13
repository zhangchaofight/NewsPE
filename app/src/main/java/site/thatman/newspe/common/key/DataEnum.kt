package site.thatman.newspe.common.key

@Suppress("SpellCheckingInspection")
object DataEnum {

    object JuheKeys {
        const val JUHE_NEWS_KEY = ""
        const val JUHE_WX_KEY = ""
    }

    enum class JuheNewsIndex(val index: String, val title: String) {
        TOP("top", "头条"),
        SHEHUI("shehui", "社会"),
        GUONEI("guonei", "国内"),
        YULE("yule", "娱乐"),
        TIYU("tiyu", "体育"),
        JUNSHI("junshi", "军事"),
        KEJI("keji", "科技"),
        CAIJING("caijing", "财经"),
        SHISHANG("shishang", "时尚");
//        val NEWS_INDEX_MAP = mapOf("top" to "头条",
//                "shehui" to "社会",
//                "guonei" to "国内",
//                "yule" to "娱乐",
//                "tiyu" to "体育",
//                "junshi" to "军事",
//                "keji" to "科技",
//                "caijing" to "财经",
//                "shishang" to "时尚")
    }
}