package com.milev.bookcatalog.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.milev.bookcatalog.R
import com.milev.bookcatalog.databinding.FragmentBookDetailBinding

/**
 * Shows a single book, or an empty form when a new book is being added.
 * The book is identified by the [ARG_BOOK_ID] argument; [NEW_BOOK_ID] means "new book".
 */
class BookDetailFragment : Fragment() {

    private var _binding: FragmentBookDetailBinding? = null
    private val binding get() = _binding!!

    private val bookId: Long
        get() = arguments?.getLong(ARG_BOOK_ID, NEW_BOOK_ID) ?: NEW_BOOK_ID

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentBookDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailTitle.text = if (bookId == NEW_BOOK_ID) {
            getString(R.string.new_book)
        } else {
            getString(R.string.book_number, bookId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_BOOK_ID = "bookId"
        const val NEW_BOOK_ID = -1L
    }
}
