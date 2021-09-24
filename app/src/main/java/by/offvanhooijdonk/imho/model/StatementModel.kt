package by.offvanhooijdonk.imho.model

data class StatementModel(
    val id: String,
    val title: String,
    val text: String,
)

data class VoteModel(
    val userId: String,
    val statement: String,
    val vote: Boolean,
)