package test.cs.composedex.network.responses.pokemon

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)