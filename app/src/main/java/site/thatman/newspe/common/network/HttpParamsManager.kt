package site.thatman.newspe.common.network

object HttpParamsManager {

    private val params: HashMap<String, String> = hashMapOf()

    @Synchronized
    fun addParams(key: String, value: String) {
        params[key] = value
    }

    @Synchronized
    fun addParams(params: Map<String, String>) {
        this.params.putAll(params)
    }

    @Synchronized
    fun removeParams(key: String) {
        params.remove(key)
    }

    @Synchronized
    fun getParams():Map<String, String> {
        val map =  hashMapOf<String, String>()
        params.entries.forEach {
            map[it.key] = it.value
        }
        return map
    }
}