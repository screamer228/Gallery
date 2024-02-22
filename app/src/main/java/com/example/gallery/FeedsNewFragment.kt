package com.example.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gallery.adapters.FeedsRecyclerAdapter
import com.example.gallery.databinding.FragmentFeedsNewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedsNewFragment : Fragment() {

    private lateinit var _binding: FragmentFeedsNewBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedsNewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList = listOf("https://s3-alpha-sig.figma.com/img/03cf/2142/c00f61d88b72d9074801db979dbfc693?Expires=1709510400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=qS0oz2ZK1vlzw91i92nev8oI8KTLzOpEyPEUJVKy5cWeKT8r38mXE3PZW9lhhr6DVs8BgRGb9KHacQ4N0uDRNDA1LocJ1lmFcWg8mXCVNemJYGmeqVxmd0Pqg4dZw4IwQSnLRPjp4npJViY-onGRLJ5r50KSNsOcG4qv63g4s4Wd49gdEm0WCUuPiNEO-XqNiawgJpqzi0wmAsnfdmZN2e2VkTEtm8qmQZBKIsKjzR9v~2IAV6SCYdqw1J~1dGMjl-Y1h0U0m8MiY0yjZt6fN4HMoNi~gV5N7UyjwZcIp3PWPU0VhZ917EpM9~5AW5Md0SOyqUbyMGNfV~iO3NXZPA__",
            "https://s3-alpha-sig.figma.com/img/5ef0/14d5/67b67a32e640c5c78549160b0e86558c?Expires=1709510400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=RaK6Qgxpd6zoM27lk27ffMkYeH2~ixkKGxN78KCnrTncjDnk1XLAhyXsETZkNufQLchpAn6~eE4YTRfwHLvjTbqlSVEq~rsSDadmO69r1Sei5ibAmyfhGZ-i5S6LYFMR5o0iYxXBwD~vBmwVgzdGEcQ537casbdUDnOBuyqdUAFWxs3Ecy2enPMdIZ0XRMkuH~1H1efVu1JZjEto4dANn8QZkw0W4WCeEwjR-j5q8EP1EQIxNWeA10lW~OxeRQ5hk6Xhrh75xkhDW~XxefNizgKJN-BUUm3NoI1fherEA7w~neU9FhOAuZuFM~PxN1CoU8lK-5aVOocZbpMJ5wGTxQ__",
            "https://s3-alpha-sig.figma.com/img/9d75/0902/cea72eddb97574c53405e8aca9eff487?Expires=1709510400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Y435P~3bC7RwjFKzHxPYKZZnKCUtOFeqVGBaNkPNtsaNjrDgdXiuBSO0sE1w80fGYkS6IJNpBxpwhAQsyIzoCRDfkQCitd6d3pzI9pRdMSpflp8F4tUcefgCqqesfObiPeKNTNhE~RJhxgVQRTxuUMG9ik9iDIkcTzaBxLsUxbR~znegUdMmPu88H6yrqzvRtu~lK12NQoV5DCH13Pu7uoF5~guG-8X9xJOEVqz-KzVKhous~55XKtdSuGgMwIXhm4CraP6EFFhNKTujKn8h8fB7~-uQdZWGTwed6bqAOuI-W88WwGz1Z82d3N49KYs~AgsBSdpmfwvhntfRAJzDJQ__",
            "https://s3-alpha-sig.figma.com/img/c3d9/5f02/b8cf22053e0fce651370eb93ff51ebba?Expires=1709510400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=NwAgOS5W3Vg0dai4iBX36L1jc~1cFrn9ukLVzLrzholbTutUkp~ZjC8rtnvdcA1OspahvO-klFKQ0FFpUnR25VZ4Y-OzMAUpMK-9Nh1VEzTYDlz7meEBa3runZBCUfhGxF-9WFkQZ0PBKcLvtC9UjN7xbmYty1bzIihJr32U7zD~3vMDg94t6rLL7jy-SgC-rnTXoiv-6Q3VFsR8xV9P7N5vRMiubm6SP8vtabyv6KIhv-3Epu9mTJ~kNoZSZbveg6hekVEag2JtfxBNV~8E3sjVuvLOehgWjigL4-TH7otUulYnzbzwJsvBfR6FcgcFfuEgccsOo-W6XWVIQ-QdDg__",
            "https://s3-alpha-sig.figma.com/img/04a0/0f52/31e28308e16877965fe7a511b60e90dd?Expires=1709510400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=PLPoo3hhK-rKV9YRjQUECFjp0unaCDbBVzTQvp4VlWdgmUD3auocN6fwVUDjgeUwW7q7z6fjW25cOc4SCs0MiHls~xkMxQtIHWvAvFciXiJZWKA-yJXPO1dzW9HQvc~GdW7kGHqdbSW7iFn7bFfo4TS48VvtYFC6Ok~jYKhE192sgMlchZNPgAikbaZiT9SBoxb8KDUpsSK5rBsvRqi-kqDPyDEOEE1yz6eyEMDAWSzKvdpL3gU8cPoaaXBzEzUz8a93NigvMHTkqvGiPu~RmXBRuYMgOwIM7EJZ1eTWiVcFmphlPrIen7fWaEy-onlAfIOWjhhxsqmFLImqM7otXA__")

        val adapter: FeedsRecyclerAdapter = FeedsRecyclerAdapter(dataList)

        binding.rvFeedsNew.adapter = adapter
    }

    companion object {
        fun newInstance() = FeedsNewFragment()
    }
}