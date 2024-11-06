package com.tc.gptchat.views

import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.html.Header
import com.vaadin.flow.theme.lumo.LumoUtility.Background
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize
import com.vaadin.flow.theme.lumo.LumoUtility.Padding
import com.vaadin.flow.theme.lumo.LumoUtility.TextAlignment
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor
import com.vaadin.flow.theme.lumo.LumoUtility.Width

class MainLayout : AppLayout() {

    init {
        primarySection = Section.NAVBAR
        addHeaderContent()
    }

    private fun addHeaderContent() {
        val title = H1("PathBuddy Chat: Plan Your Next Adventure").apply {
            addClassNames(FontSize.XLARGE, TextColor.PRIMARY_CONTRAST, TextAlignment.CENTER)
        }

        val header = Header(title).apply {
            addClassNames(Width.FULL, Padding.MEDIUM, Background.CONTRAST)
        }

        addToNavbar(true, header)
    }
}