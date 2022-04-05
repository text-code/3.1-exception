package list.of.objects

class Comments(val id: Int, private val comment: String) {
    override fun toString(): String {
        return "$id) Комментарий: $comment"
    }
}