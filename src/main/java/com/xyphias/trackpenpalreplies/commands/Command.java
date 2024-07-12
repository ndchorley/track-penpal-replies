package com.xyphias.trackpenpalreplies.commands;

public sealed interface Command permits AddLetter, ListLetters, Quit {}
