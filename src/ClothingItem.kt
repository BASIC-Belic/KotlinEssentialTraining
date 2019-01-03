// POJO / Java  Beans / Data Transfer Objects ... in Kotlin: data class
//data class must have at least one field (declare as part of class declaration, primary class constructor)
// common pattern: private fields with public setter and getter
//free functionality: auto generate toString function
//dont need body {} bc of getter / setter methods
// manages data objs
data class ClothingItem(val type:String,
                        val size:String,
                        var price:Double)