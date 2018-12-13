@file:Suppress("unused")

package site.thatman.newspe.common.util

import com.alibaba.fastjson.JSON
import java.lang.reflect.Type

//封装FastJson转换
object GsonUtil {

    fun toJson(any:Any):String =  JSON.toJSONString(any)

    fun <T: Any> fromJson(json: String, clazz: Class<T>): T = JSON.parseObject(json, clazz)

    fun <T: Any> fromJson(json: String, type: Type): T = JSON.parseObject(json, type)

    fun <T: Any> fromJsonArray(json: String, clazz: Class<T>): MutableList<T> = JSON.parseArray(json, clazz)

    fun fromJsonArray(json: String, types: Array<Type>): List<Any> = JSON.parseArray(json, types)
}