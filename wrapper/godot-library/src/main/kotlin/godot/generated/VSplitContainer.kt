@file:Suppress("unused", "ClassName", "EnumEntryName", "FunctionName", "SpellCheckingInspection", "PARAMETER_NAME_CHANGED_ON_OVERRIDE", "UnusedImport", "PackageDirectoryMismatch")
package godot

import godot.gdnative.*
import godot.core.*
import godot.utils.*
import godot.icalls.*
import kotlinx.cinterop.*


// NOTE: THIS FILE IS AUTO GENERATED FROM JSON API CONFIG


open class VSplitContainer : SplitContainer {
    constructor() : super("VSplitContainer")
    constructor(variant: Variant) : super(variant)
    internal constructor(mem: COpaquePointer) : super(mem)
    internal constructor(name: String) : super(name)


    // Enums 



    // Signals
    class Signal {
        companion object {
        }
    }


    companion object {
        infix fun from(other: SplitContainer): VSplitContainer = VSplitContainer("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Container): VSplitContainer = VSplitContainer("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Control): VSplitContainer = VSplitContainer("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: CanvasItem): VSplitContainer = VSplitContainer("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Node): VSplitContainer = VSplitContainer("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Object): VSplitContainer = VSplitContainer("").apply { setRawMemory(other.rawMemory) }
        infix fun from(other: Variant): VSplitContainer = fromVariant(VSplitContainer(""), other)


        // Constants


    }


    // Properties


    // Methods
}
