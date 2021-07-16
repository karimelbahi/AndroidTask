package com.karim.task.presentation.ui.mostPopularDetails

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.karim.task.R
import com.karim.task.databinding.FragmentPostListDetailsBinding
import com.karim.task.presentation.ui.mostPopular.MostPopularModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MostPopularDetails : Fragment() {

    private val viewModel by viewModels<MostPopularModel>()
    private lateinit var binding: FragmentPostListDetailsBinding
    private val args: MostPopularDetailsArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<FragmentPostListDetailsBinding>(
            inflater,
            R.layout.fragment_post_list_details,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (args.postId.media.isNullOrEmpty())
            Picasso.get().load(R.drawable.ic_place_holder)
                .into(binding.imagePost);
        else
            Picasso.get().load(args.postId.media[0].media_metadata[0].url)
                .into(binding.imagePost);

        binding.textTitle.text = textStyle(
            0,
            5,
            "TITLE : " + args.postId.title + ".",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.textAbstract.text = textStyle(
            0,
            8,
            "ABSTRACT : " + args.postId.abstract + ".",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.textByline.text = textStyle(
            0,
            2,
            "BY : " + args.postId.byline + ".",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.textSource.text = textStyle(
            0,
            6,
            "SOURCE : " + args.postId.source + ".",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.textPublishedDate.text = textStyle(
            0,
            14,
            "PUBLISHED DATE : " + args.postId.published_date + ".",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.textUpdated.text = textStyle(
            0,
            6,
            "UPDATE : " + args.postId.updated + ".",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.textSection.text = textStyle(
            0,
            7,
            "SECTION : " + args.postId.section + ".",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.textAdxKeyword.text = textStyle(
            0,
            7,
            "KEYWORD : " + args.postId.adx_keywords + ".",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.textUri.text = textStyle(
            0,
            3,
            "URI : " + args.postId.uri + ".",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.textUrl.text = textStyle(
            0,
            3,
            "URL : " + args.postId.url + ".",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.textType.text = textStyle(
            0,
            4,
            "TYPE : " + args.postId.type + ".",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    private fun textStyle(start: Int, end: Int, str: String, style: Int): SpannableString {

        val ss = SpannableString(str)
        ss.setSpan(StyleSpan(Typeface.BOLD), start, end, style)
        return ss
    }

}