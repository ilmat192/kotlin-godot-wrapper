fun String.escapeUnderscore(): String {
    if (this == "")
        return this

    var ret = this

    while (ret[0] == '_')
        ret = ret.drop(1)
    return ret
}



fun String.removeEnumPrefix(): String {
    if (this == "")
        return this

    var ret = this

    val ind = ret.indexOf("enum.")
    if (ind != -1)
        ret = ret.drop(ind + 5)

    if (ret == "Error")
        return "GodotError"
    return ret.replace("::", ".").escapeUnderscore()
}




fun String.isEnum(): Boolean {
    return this.indexOf("enum.") == 0
}

fun String.isPrimitive(): Boolean {
    val primitives = listOf("Int", "Float", "Boolean", "Unit")
    return primitives.find { s -> s == this } != null
}

fun String.isCoreType(): Boolean {
    val coreTypes = listOf(//"Array", // TODO: kotlin arrays?
            "GodotArray",
            "Basis",
            "Color",
            "Dictionary",
            "GodotError",
            "NodePath",
            "Plane",
            "PoolByteArray",
            "PoolIntArray",
            "PoolRealArray",
            "PoolStringArray",
            "PoolVector2Array",
            "PoolVector3Array",
            "PoolColorArray",
            "PoolIntArray",
            "PoolRealArray",
            "Quat",
            "Rect2",
            "AABB",
            "RID",
            "String",
            "Transform",
            "Transform2D",
            "Variant",
            "Vector2",
            "Vector3")
    return coreTypes.find { s -> s == this } != null
}



fun String.escapeKotlinReservedNames(): String {
    val names = listOf("class", "enum", "interface", "in", "var", "val", "Char", "Short", "Boolean", "Int", "Float", "Double", "operator", "object") // TODO: smth more?

    if (names.find { s -> s == this } != null)
        return "_" + this
    return this
}




fun String.convertToCamelCase(): String {
    if (this == "")
        return this

    var ret = this

    val prefix = buildString {
        while (ret != "" && ret[0] == '_') {
            this.append('_')
            ret = ret.drop(1)
        }
    }

    var split = ret.split('_')
    val first = split[0]
    split = split.drop(1)

    return prefix + first + split.joinToString("") { it.capitalize() }
}




fun String.convertTypeToKotlin(): String {
    if (this == "int")
        return "Int"
    if (this == "float")
        return "Float"
    if (this == "bool")
        return "Boolean"
    if (this == "void")
        return "Unit"
    if (this == "Array")
        return "GodotArray" // TODO: kotlin arrays?
    if (!this.isCoreType() && !this.isEnum() && !this.isPrimitive()) return "Object" // FIXME: remove line
    return this
}

fun String.convertTypeForICalls(): String {
    if (this.isEnum())
        return "Int"
    if (this.isPrimitive() || this.isCoreType())
        return this
    return "Object"
}



fun String.defaultValue(): String = when (this) {
    "Int" -> "0"
    "Float" -> "0f"
    "Boolean" -> "false"
    else -> "null"
}