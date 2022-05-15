package domain

import domain.criterios.CriterioDeAprovacao

class AnalisadorDeAprovacao {
    private var criterio: CriterioDeAprovacao? = null

    fun defineCriterio(criterio: CriterioDeAprovacao) {
        this.criterio = criterio
    }

    fun fechaBoletim(boletim: Boletim): BoletimFechado {
        val criterio = this.criterio ?:
            throw IllegalStateException(
                "Critério de Aprovação não definido"
            )

        return BoletimFechado(
            boletim.mediaEPs,
            boletim.mediaMiniEPs,
            criterio.mediaFinal(boletim),
            criterio.estaAprovado(boletim)
        )
    }
}
