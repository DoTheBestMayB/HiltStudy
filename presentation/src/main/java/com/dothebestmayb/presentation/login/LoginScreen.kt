package com.dothebestmayb.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dothebestmayb.presentation.component.HSButton
import com.dothebestmayb.presentation.component.HSTextField
import com.dothebestmayb.presentation.theme.HiltStudyTheme
import org.orbitmvi.orbit.compose.collectAsState

// 1. LoginScreen을 또 만든 이유는 viewModel이 preview에 나타나지 않기 때문에 별도로 분리
// 2. viewModel을 사용하면 Navigation Component를 사용해 LoginScreen에서 다른 Screen으로 이동할 때
// LoginScreen이 backStack에 없으면 ViewModel이 소멸되어야 하는데, 소멸이 안 된다.
// 그래서 hilt navigation compose 라이브러리에 있는 hiltViewModel을 사용해서 viewModel의 생명주기를 관리해야 한다.
// 로직을 수행하기 위해 viewModel을 포함한 composable
@Composable
fun LoginScreen(
//    viewModel: LoginViewModel = viewModel() // 그냥 viewModel을 사용하면 위 2번의 문제 발생
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.collectAsState().value
    LoginScreen(
        id = state.id,
        password = state.password,
        onIdChange = viewModel::onIdChange,
        onPasswordChange = viewModel::onPasswordChange,
        onNavigateToSignUpScreen = {},
        onLoginClick = viewModel::onLoginClick,
    )
}

// Preview를 그리기 위한 Composable
@Composable
private fun LoginScreen(
    id: String,
    password: String,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNavigateToSignUpScreen: () -> Unit,
    onLoginClick: () -> Unit,
) {

    Surface {
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Column(
                modifier = Modifier.padding(top = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Connected", style = MaterialTheme.typography.displaySmall)
                Text(
                    text = "Your favorite social network",
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(top = 36.dp)
                )
                Text(
                    text = "Id",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(top = 16.dp)
                )
                HSTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    value = id,
                    onValueChange = onIdChange
                )
                Text(
                    text = "Password",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(top = 16.dp)
                )
                HSTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    value = password,
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = onPasswordChange
                )
                HSButton(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .fillMaxWidth(),
                    text = "로그인",
                    onClick = onLoginClick,
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 24.dp)
                        .clickable(onClick = onNavigateToSignUpScreen)
                ) {
                    Text(text = "Don't have an account?")
                    Text(
                        text = "Sign up",
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    HiltStudyTheme {
        LoginScreen(
            id = "urna",
            password = "accommodare",
            onIdChange = {},
            onPasswordChange = {},
            onNavigateToSignUpScreen = {},
            onLoginClick = {},
        )
    }
}