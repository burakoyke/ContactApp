package com.burakoyke.contacts.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.burakoyke.contacts.R
import com.burakoyke.contacts.data.entity.Contacts
import com.burakoyke.contacts.databinding.CardDesignBinding
import com.burakoyke.contacts.ui.fragment.MainPageFragmentDirections
import com.burakoyke.contacts.ui.viewModel.MainPageViewModel
import com.google.android.material.snackbar.Snackbar

class ContactAdapter (var mContext : Context, var contactList : List<Contacts>, var viewModel : MainPageViewModel) : RecyclerView.Adapter<ContactAdapter.CardDesignHolder>(){
    inner class CardDesignHolder(var design : CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding : CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.card_design,parent,false)
        return CardDesignHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val contact = contactList.get(position)
        val t = holder.design
        t.contact = contact

        t.cardView.setOnClickListener {
            val gecis = MainPageFragmentDirections.actionMainPageFragmentToContactDetailFragment(contact = contact)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewDelete.setOnClickListener {
            Log.d("Button", "Button Clicked")
            Snackbar.make(it,"Are you sure?",Snackbar.LENGTH_LONG)
                .setAction("YES"){
                    delete(contact.id)
                }
                .show()
        }

    }

    fun delete(id : Int){
       viewModel.delete(id)
    }
}