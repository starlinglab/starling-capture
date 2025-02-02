package io.numbersprotocol.starlingcapture.collector.proofmode

import android.content.Context
import androidx.core.net.toUri
import androidx.work.WorkerParameters
import io.numbersprotocol.starlingcapture.collector.InformationProvider
import io.numbersprotocol.starlingcapture.data.information.Information
import io.numbersprotocol.starlingcapture.data.proof.ProofRepository
import org.koin.core.KoinComponent
import org.koin.core.inject
//import org.witness.proofmode.ProofMode
import java.io.File

/*
class ProofModeProvider(
    context: Context,
    params: WorkerParameters
) : InformationProvider(context, params), KoinComponent {

    override val name = ProofModeConfig.name

    private val proofRepository: ProofRepository by inject()
    private lateinit var generatedDir: File

    override suspend fun onStarted() {
        super.onStarted()
        val proofRawFile = proofRepository.getRawFile(proofRepository.getByHash(hash)!!)
        val hashFromProofMode = ProofMode.generateProof(context, proofRawFile.toUri())
        if (hashFromProofMode.isEmpty()) throw IllegalStateException("Cannot generate proof by ProofMode.")
        generatedDir = ProofMode.getProofDir(hashFromProofMode)
        if (!generatedDir.exists()) throw IllegalStateException("Cannot locate information directory generated by ProofMode: $hashFromProofMode")
    }

    override suspend fun provide(): Collection<Information> {
        val infoText = generatedDir.listFiles { _, filename ->
            filename.endsWith(INFORMATION_FILE_SUFFIX)
        }!!.first().readText()
        val rawFileSignatureText = generatedDir.listFiles { _, filename ->
            filename.endsWith(RAW_FILE_SIGNATURE_FILE_SUFFIX)
        }!!.first().readText()
        val informationSignatureText = generatedDir.listFiles { _, filename ->
            filename.endsWith(INFORMATION_SIGNATURE_FILE_SUFFIX)
        }!!.first().readText()
        return setOf(
            Information(hash, name, name, infoText, Information.Importance.HIGH),
            Information(
                hash,
                name,
                "Raw File Signature",
                rawFileSignatureText,
                Information.Importance.LOW
            ),
            Information(
                hash,
                name,
                "Information Signature",
                informationSignatureText,
                Information.Importance.LOW
            )
        )
    }

    override suspend fun onCleared() {
        super.onCleared()
        if (generatedDir.exists()) generatedDir.delete()
    }

    companion object {
        const val INFORMATION_FILE_SUFFIX = ProofMode.PROOF_FILE_TAG
        const val INFORMATION_SIGNATURE_FILE_SUFFIX =
            "${ProofMode.PROOF_FILE_TAG}${ProofMode.OPENPGP_FILE_TAG}"
        const val RAW_FILE_SIGNATURE_FILE_SUFFIX = ProofMode.OPENPGP_FILE_TAG
    }
}
*/