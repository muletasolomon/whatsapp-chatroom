package com.whatsapp.spring.swagger.controller;

import com.whatsapp.spring.swagger.service.EmojiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Emoji or reactions", description = "Emoji list or reaction list API")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmojiController {


    @Autowired
    EmojiService emojiService;

//    @Operation(summary = "Retrieve all emoji List", tags = {"emojis"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = String.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "There are no emojiList", content = {
                    @Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/emojiList")
    public ResponseEntity<List<String>> emojiList(@RequestParam(required = false) String title) {
        try {
            if (title != null) {
                String emoji = emojiService.getEmoji(title);
                if (emoji != null) {
                    return new ResponseEntity<>(List.of(emoji), HttpStatus.OK);
                }
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            } else {
                List<String> emojis = emojiService.getReactions();

                if (emojis.isEmpty() || emojis.equals("")) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(emojis, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
