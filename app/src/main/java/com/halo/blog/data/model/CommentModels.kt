package com.halo.blog.data.model

import com.google.gson.annotations.SerializedName

/**
 * 评论响应
 */
data class CommentResponse(
    val page: Int,
    val size: Int,
    val total: Int,
    val items: List<Comment>,
    val first: Boolean,
    val last: Boolean,
    val hasNext: Boolean,
    val hasPrevious: Boolean,
    val totalPages: Int
)

/**
 * 评论
 */
data class Comment(
    val metadata: CommentMetadata,
    val spec: CommentSpec,
    val status: CommentStatus,
    val owner: CommentOwner,
    val stats: CommentStats
)

/**
 * 评论元数据
 */
data class CommentMetadata(
    val finalizers: List<String>,
    val name: String,
    val annotations: Map<String, String>,
    val version: Int,
    val creationTimestamp: String
)

/**
 * 评论规格
 */
data class CommentSpec(
    val raw: String,
    val content: String,
    val owner: CommentSpecOwner,
    val userAgent: String,
    val ipAddress: String,
    val approvedTime: String?,
    val creationTime: String,
    val priority: Int,
    val top: Boolean,
    val allowNotification: Boolean,
    val approved: Boolean,
    val hidden: Boolean,
    val subjectRef: CommentSubjectRef,
    val lastReadTime: String?
)

/**
 * 评论规格所有者
 */
data class CommentSpecOwner(
    val kind: String,
    val name: String,
    val displayName: String,
    val annotations: Map<String, String>
)

/**
 * 评论主题引用
 */
data class CommentSubjectRef(
    val group: String,
    val version: String,
    val kind: String,
    val name: String
)

/**
 * 评论状态
 */
data class CommentStatus(
    val lastReplyTime: String?,
    val replyCount: Int,
    val visibleReplyCount: Int,
    val unreadReplyCount: Int,
    val hasNewReply: Boolean,
    val observedVersion: Int
)

/**
 * 评论所有者
 */
data class CommentOwner(
    val kind: String,
    val displayName: String
)

/**
 * 评论统计
 */
data class CommentStats(
    val upvote: Int
)

/**
 * 用于显示的评论项
 */
data class CommentItem(
    val id: String,
    val content: String,
    val authorName: String,
    val creationTime: String,
    val upvoteCount: Int,
    val replyCount: Int,
    val hasReplies: Boolean
) {
    companion object {
        fun fromComment(comment: Comment): CommentItem {
            return CommentItem(
                id = comment.metadata.name,
                content = comment.spec.content,
                authorName = comment.owner.displayName,
                creationTime = comment.spec.creationTime,
                upvoteCount = comment.stats.upvote,
                replyCount = comment.status.replyCount,
                hasReplies = comment.status.replyCount > 0
            )
        }
    }
}

/**
 * 发表评论请求
 */
data class CommentRequest(
    val raw: String,
    val content: String,
    val allowNotification: Boolean,
    val subjectRef: CommentSubjectRef
)