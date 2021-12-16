package test.cs.composedex.network.responses.pokemon

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)