package group.payback.codingchallengeapplication.data.remote

import group.payback.codingchallengeapplication.data.remote.dto.HitDTO
import group.payback.codingchallengeapplication.data.remote.dto.ImagesResponseDTO
import group.payback.codingchallengeapplication.domain.models.Hit

fun HitDTO.toHitFromRemoteToDomain(): Hit {
    return Hit(
        id = id,
        collections = collections,
        comments = comments,
        downloads = downloads,
        imageHeight = imageHeight,
        imageSize = imageSize,
        imageWidth = imageWidth,
        largeImageURL = largeImageURL,
        likes = likes,
        pageURL = pageURL,
        previewHeight = previewHeight,
        previewURL = previewURL,
        previewWidth = previewWidth,
        tags = tags,
        type = type,
        user = user,
        userImageURL = userImageURL,
        user_id = user_id,
        views = views,
        webformatHeight = webformatHeight,
        webformatURL = webformatURL,
        webformatWidth = webformatWidth
    )
}

fun HitDTO.toHitFromRemoteToLocal(word: String): group.payback.codingchallengeapplication.data.local.entities.Hit {
    return group.payback.codingchallengeapplication.data.local.entities.Hit(
        id = id,
        wordQuery=word,
        collections = collections,
        comments = comments,
        downloads = downloads,
        imageHeight = imageHeight,
        imageSize = imageSize,
        imageWidth = imageWidth,
        largeImageURL = largeImageURL,
        likes = likes,
        pageURL = pageURL,
        previewHeight = previewHeight,
        previewURL = previewURL,
        previewWidth = previewWidth,
        tags = tags,
        type = type,
        user = user,
        userImageURL = userImageURL,
        user_id = user_id,
        views = views,
        webformatHeight = webformatHeight,
        webformatURL = webformatURL,
        webformatWidth = webformatWidth
    )
}


//fun ImagesResponseDTO.toImagesResponse(): ImagesResponse {
//    return ImagesResponse(
//        hits = hits.map { it.toHit() }, total = total, totalHits = totalHits
//    )
//}






