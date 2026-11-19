package com.milev.bookcatalog.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.milev.bookcatalog.R
import com.milev.bookcatalog.databinding.FragmentBookListBinding
import com.milev.bookcatalog.ui.detail.BookDetailFragment

/**
 * Start screen: shows the user's books.
 * For now it only shows an empty state and the "add book" button,
 * which opens the detail screen in "new book" mode.
 */
class BookListFragment : Fragment() {

    // The binding exists only between onCreateView and onDestroyView.
    // Clearing it in onDestroyView prevents a memory leak of the old view.
    private var _binding: FragmentBookListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentBookListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addBookButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_list_to_detail,
                bundleOf(BookDetailFragment.ARG_BOOK_ID to BookDetailFragment.NEW_BOOK_ID),
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
