import list.of.objects.Comments

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comments>()
    private var listId: Int = 0

    fun add(post: Post): Post {
        listId++
        val postId = post.copy(id = listId)
        posts += postId
        return posts.last()
    }

    fun update(postUpdate: Post): Boolean {
        for (post in posts) {
            if (postUpdate.id == post.id) {
                val newPost = postUpdate.copy(ownerId = post.ownerId, date = post.date)
                posts[post.id - 1] = newPost
                return true
            } else if (postUpdate.id >= posts.size) {
                return false
            }
        }
        return false
    }

    fun createComment(comment: Comments): Boolean {
        for (post in posts) {
            if (post.id == comment.id) comments += comment
            return true
        }
        throw PostNotFoundException("Post not founded")
    }
}