package cz.mireksirina.movies.presentation.home.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import cz.mireksirina.movies.R
import cz.mireksirina.movies.domain.model.Result
import cz.mireksirina.movies.ui.theme.MoviesTheme
import cz.mireksirina.movies.util.Constants.ArticleCardSize
import cz.mireksirina.movies.util.Constants.ExtraSmallPadding
import cz.mireksirina.movies.util.Constants.ExtraSmallPadding2
import cz.mireksirina.movies.util.Constants.IMG_URL
import cz.mireksirina.movies.util.Constants.MoviePosterDefaultSize
import cz.mireksirina.movies.util.Constants.SmallIconSize


@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    movie: Result,
    onClick: (() -> Unit)? = null
) {

    val context = LocalContext.current
    Row(
        modifier = modifier.clickable { onClick?.invoke() },

        ) {
        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),

            // image request url
            // http://image.tmdb.org/t/p/w154/xyAXFy6mOfgZcVWbceCeuTYadeq.jpg
            model = ImageRequest.Builder(context).data("$IMG_URL$MoviePosterDefaultSize${movie.poster_path}").build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.bodyMedium.copy(),
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = movie.original_language,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding))
                Text(
                    text = movie.release_date,
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    MoviesTheme(dynamicColor = false) {
        MovieCard(
            movie = Result(
                adult = false,
                backdrop_path = "/example_backdrop_path.jpg",
                genre_ids = listOf(28, 12, 16),
                id = 12345,
                original_language = "en",
                original_title = "Mock Movie Title",
                overview = "This is a mock overview of the movie.",
                popularity = 87.5,
                poster_path = "/xyAXFy6mOfgZcVWbceCeuTYadeq.jpg",
                release_date = "2024-01-23",
                title = "Mock Movie Title",
                video = true,
                vote_average = 8.9,
                vote_count = 1000
            )
        )
    }
}