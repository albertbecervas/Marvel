package com.abecerra.marvel_domain.usecase

import com.abecerra.marvel_domain.repository.CharactersRepository
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.willReturn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCharactersUseCaseTest {

    private lateinit var getCharactersUseCase: GetCharactersUseCase

    @Mock
    private lateinit var charactersRepository: CharactersRepository

    @Before
    fun setUp() {
        getCharactersUseCase = GetCharactersUseCase(charactersRepository)
        given { charactersRepository.getCharacters() }.willReturn { arrayListOf() }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetCharactersReturnsCharactersListOnApiSuccess() {
        runBlocking { getCharactersUseCase.execute {} }

        verify(charactersRepository).getCharacters()
        verifyNoMoreInteractions(charactersRepository)
    }
}